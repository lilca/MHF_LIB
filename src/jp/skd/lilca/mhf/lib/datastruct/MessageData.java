package jp.skd.lilca.mhf.lib.datastruct;

//import java.util.Random;
/**
 * �N�����b�Z�[�W�𒊏ۉ������N���X
 */
public class MessageData {
	/**
	 * �N�����b�Z�[�W
	 */
	private static final String[][] messages = {
		{"�A�v�����J���~�̂��m�点", "������ɂ��A2013/09/19 ��12�����������đ��������H�����J���~�ɒv���܂��B�ڍׂ͎���URL�����Q�Ƃ��������Bhttp://skd.backdrop.jp/noproblem/",},
		{"cLoud�ŃT�[�r�X��L���ɁI", "cLoud��o�^������A��������Q�l�ɃT�[�r�X��L���ɂ��ĉ������Bhttp://skd.backdrop.jp/noproblem/editpagemise.php?%C6%C3%BD%B8#c8a518fc",},
		{"�u���O�ɑ��������H��\�낤", "�X������Α��������H�̃u���O�p�[�c���u���O�ɓ\��܂��񂩁Bhttp://skd.backdrop.jp/noproblem/editpagemise.php?%C6%C3%BD%B8#l117eb47",},
	};
	/**
	 * �^�C�g���ƃ��b�Z�[�W���擾����
	 * @return �^�C�g���ƃ��b�Z�[�W
	 */
	public static String[] getMessageAtRandom(){
//		Random rnd = new Random();
//		return messages[rnd.nextInt(messages.length)];
		return messages[0];
	}
}
