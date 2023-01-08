package com.example.simpledms.configuration;

import com.example.simpledms.security.auth.CustomOAuth2UserService;
import com.example.simpledms.security.auth.OAuth2SuccessHandler;
import com.example.simpledms.security.jwt.AuthEntryPointJwt;
import com.example.simpledms.security.jwt.AuthTokenFilter;
import com.example.simpledms.security.services.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// spring security 라이브러리를 설치하면
// 기본적으로 모든 url 에 대해 인증을 진행함
// 내부적으로 사용하고 있는 로그인페이지로 자동 리다이렉트함
// 기본 user id : user , pwd: 콘솔에 보임
// application.properties 파일에 user/pwd 설정 가능
// 아래 클래스에서 인증/접근권한을 설정할 수 있음
@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;  // DB 조회 함수 객체

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler; // 비인증/권한체크 예외처리 객체
    //
    @Autowired
    private OAuth2SuccessHandler oAuth2SuccessHandler;

    //  구글 로그인 이후 가져온 사용자의 정보(email,name,picture등) 들을 기반으로 가입 및 정보수정, 세션 저장 등의 기능을 지원
    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    //  JWT 토큰 필터 객체 생성
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }


    //  DB 에서 가져온 정보와 input 된 정보를 비교하는 함수
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        //  db에서 가져온 정보와 input 된 정보를 비교하는 객체
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService); // DB 유저 조회 함수 객체
        authProvider.setPasswordEncoder(passwordEncoder()); // 암호 적용된 페스워드

        return authProvider;
    }

    //  AuthenticationManager 를 클래스 외부에서 사용하기 위해
//  아래 함수 정의 않하면 @Autodwired 로 가져올 때 에러가 발생할 수 있음
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    //  패스워드 암호화 함수
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * 스프링 시큐리티 룰을 무시하게 하는 Url 규칙(여기 등록하면 규칙 적용하지 않음)
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/js/**", "/images/**", "/css/**");
    }

    //  스프링 시큐리티 룰을 무시하게 하는 Url 규칙(여기 등록하면 규칙 적용하지 않음)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors()
                .and(). // 연결
                csrf().disable() // csrf 보안 비활성화
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and() // 인증 예외처리는 AuthEntryPointJwt
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()// 세션안쓰고(stateful) JWT 사용 예정
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()// EVER 옵션은 세션을 사용하진 않지만 만약 필요하다면 세션을 생성해주는 옵션
                .authorizeRequests().antMatchers("/api/auth/**").permitAll() // 이 url 은 모든 사용자 접근 허용
                .antMatchers("/api/test/**", "/auth-redirect", "/api/goods/**", "/api/fileDb/**", "/api/e/**", "/api/fbCategory/**",
                        "/api/fb/**", "/api/user/**", "/api/diary/**", "/api/goodcomment/**", "/api/goodreply/**", "/api/bbCategory/**", "/api/bb/**",
                        "/api/mbCategory/**", "/api/mb/**", "/api/lbCategory/**", "/api/lb/**", "/api/fblike/**", "/api/goodcart/**", "/api/todo/**",
                        "/api/fbcomment/**", "/api/fbreply/**", "/api/bbcomment/**", "/api/bbreply/**", "/api/mbcomment/**", "/api/mbreply/**",
                        "/api/lbcomment/**", "/api/lbreply/**", "/api/bblike/**", "/api/mblike/**", "/api/lblike/**").permitAll() // 이 url 은 모든 사용자 접근 허용
                .anyRequest().authenticated()
                .and()
//                OAuth 2 로그인 기능에 대한 여러 설정의 진입점입니다.
                .oauth2Login()
                .successHandler(oAuth2SuccessHandler)
//                로그인 성공 이후 토큰 발행
//                OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당합니다.
                .userInfoEndpoint()
////                소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
////                리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있음
                .userService(customOAuth2UserService);


        http.authenticationProvider(authenticationProvider()); // DB와 입력값(id, pwd) 비교

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); // JWT 토큰 필터 적용

        return http.build();
    }
}
