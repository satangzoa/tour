package com.oraclejava.tour.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean//bean을 주면 인스턴스가 만들어진다. 다른 곳에서 autowired를 사용할 수 있다.
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	
	}
	
	//configure HttpSecurity..
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//모든 링크에 대해 직접 접근 금지 및 로그인 링크 풀어줌
		//직접 접근금지 및 로그인이 필요없는 페이지 설정
		http
		//Cross site Request forgery로 사이즈간 위조 요청인데, 
		//즉 정상적인 사용자가 의도치 않은 위조요청을 보내는 것을 의미
			.csrf().disable() //csrf 금지 해제
			.authorizeHttpRequests()//csrf 무효화
				.antMatchers("/login","/css/**").permitAll()//login과 css 사용 허용한다 //접근 허가 익명사용
				.antMatchers("/customers/create").permitAll()
				.anyRequest().authenticated(); // 기타 나머지는 직접 접근 금지
		//로그인 처리 구현;
		http
			.formLogin()// --> 403페이지가 아니라 기본 로그인 창으로 이동
				.loginProcessingUrl("/login")//로그인 처리 경로(form action속성 값)  action의 url
				.loginPage("/login")//로그인 페이지 지정(컨트롤러의 RequestMapping Value 값) .get
				.failureUrl("/login?error")//로그인에 실패할 경우 이동하는 url
				.usernameParameter("userId")//사용자 id (input type = "text" 태그의 name값)
				.passwordParameter("password")// 비번 psssword (input type = "psssword" 태그의 name값)
				.defaultSuccessUrl("/", true);// 로그인 성공시 이동하는 url(보통 홈페이지),
											//true -> 무조건 홈으로 이동, false -> 요청하는 url에 따라 달라지짐
	
		//로그아웃 처리
		http
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login");
		
		
	}
	//configure는 디비에 있는 정보를 가져온다
//		@Override
//		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////			auth
////				.inMemoryAuthentication()
////				.withUser("oracle") //로그인 화면 뜨면 아이디로 입력한다
////				.password(passwordEncoder().encode("java"))
////				.roles("USER");
//			auth
//				.passwordEncoder(passwordEncoder());
//			
//			
//		}
//	
	//configure는 디비에 있는 정보를 가져온다
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
}


















