package login;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import member.Member;
import member.MemberMapper;

@Service
public class LoginService implements UserDetailsService{

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SqlSession sqlSession=sqlSessionFactory.openSession();
		MemberMapper memberDao=sqlSession.getMapper(MemberMapper.class);
		Member member=memberDao.findByUsername(username);
		
		if (member == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User user=
		new User(member.getUsername(), 
				new BCryptPasswordEncoder().encode(member.getPassword()),
				authorities);
		
		return user;
	}

}
