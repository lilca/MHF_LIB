package jp.skd.lilca.mhf.lib.buki;

import java.util.HashMap;

/**
 * ����̃����[�h�𒊏ۉ������N���X
 */
public class Reload {

	private HashMap<String, Integer> map = new HashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		{
			put("�ɒx", -1);
			put("�x��", 0);
			put("���x��", 1);
			put("����", 2);
			put("��⑬��", 3);
			put("����", 4);
			put("�ɑ�", 5);
			put("�ő�", 6);
		}
	};
	private HashMap<Integer, String> pmap = new HashMap<Integer, String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(-1, "�ɒx");
			put( 0, "�x��");
			put( 1, "���x��");
			put( 2, "����");
			put( 3, "��⑬��");
			put( 4, "����");
			put( 5, "�ɑ�");
			put( 6, "�ő�");
			put( 7, "�ő�+");
		}
	};
	private int val;

	/**
	 * �R���X�g���N�^
	 * @param src ������`���̃����[�h���
	 */
	public Reload(String src){
		Integer tmp;
		try{
			tmp = this.map.get(src);
		}catch(Exception e){
			this.val = -2;
			return;
		}
		if(tmp == null){
			this.val = -2;
			return;
		}
		this.val = tmp;
		return;
	}
	/**
	 * �����[�h���𕶎���ɏo��
	 * @param v �X�L�������Ȃǂɂ��o�C�A�X
	 * @return ������`���̃����[�h���
	 */
	public String print(int v){
		if( this.val == -2 )
			return "";
		return this.pmap.get(this.val+v);
	}
}
