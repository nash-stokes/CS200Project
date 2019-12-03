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
	 * use 'test' as the name, street, city, state.
	 * use '00000' as the ZIP
	 * use '000000000' as the member number
	 */
	@Test
  void testDeleteMemberForSuccess() {
		MemberController.addMember();
    memberList = MemberController.getMemberList();
    int sizeBeforeDelete = memberList.size();
    
    MemberController.deleteMember();
    int sizeAfterDelete = memberList.size();
    
    assertNotEquals(sizeBeforeDelete, sizeAfterDelete);
  }
	
	@Test
  void testDeleteMemberForFailure() {
		
  }

}
