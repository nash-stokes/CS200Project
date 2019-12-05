package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.MemberController;
import main.MemberData;

class ErikTest {
	ArrayList<MemberData> memberList = new ArrayList<MemberData>();
	MemberData member = new MemberData();
	
	/**
	 * use 'test' as the name, street, city, state.
	 * use '00000' as the ZIP
	 * use '000000000' as the member number
	 */
  @Test
  void testAddMemberForSuccess() { 
    MemberController.addMember();
    memberList = MemberController.getMemberList();
    member = memberList.get(memberList.size() - 1);
    assertEquals(member.getName(), "test");
  }

  /**
	 * use 'first' as the name, street, city for the first member
	 * use 'second as the name, street, city for the second member
	 * use 'AL' as the state
	 * use '00000' as the ZIP
	 * use '000000000' as the first member number
	 * use '123456789' as the second member number
	 * delete the first member (000000000)
	 */
	@Test
  void testDeleteMemberForSuccess() {
		MemberController.addMember();
		MemberController.addMember();
    MemberController.deleteMember();
    
    memberList = MemberController.getMemberList();
    String name = memberList.get(0).getName();
 
    assertEquals(name, "second");
  }
	
	@Test
  void testDeleteMemberForFailure() {
		MemberController.addMember();
		int sizeBeforeDelete = MemberController.getMemberList().size();
		
		MemberController.deleteMember();
		int sizeAfterDelete = MemberController.getMemberList().size();
		
		assertEquals(sizeBeforeDelete, sizeAfterDelete);
  }

}
