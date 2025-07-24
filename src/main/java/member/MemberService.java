package member;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberMapper dao;
	
	public void save(RegisterForm form) {
		
		Member member=new Member();
		BeanUtils.copyProperties(form, member);
		
		if (dao.countByUsername(member.getUsername()) > 0) {
		    throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
		}
		dao.save(member);
	}

}
