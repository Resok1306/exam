package member;

public interface MemberMapper {
	public int save	(Member member);
	public Member findByUsername(String username);	
	public int countByUsername(String username);
}
