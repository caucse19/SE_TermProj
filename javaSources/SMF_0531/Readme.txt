�߰� ��������

1. SimpleMergeController�� addActionLister����

2. EventHandler�� ��� Controller���� ����Ǵ� ��������
SimpleMergeFrame�� �ִ� public static int saveOption������
SimpleMergeController�� �ű�. SaveEventHandler��
SimpleMergeFrame.saveOption
=>SimpleMergeController.saveOption ����




2018-05-31 �߰� ��������

1.LoadEventHandler�� 
	private int loadOption;
	public static String leftFileName = null;
	public static String rightFileName = null;
	�߰�
	
	�����ڿ� �Ķ���� �Ѱ� �߰���Ŵ
	
	actionperformed �Լ��ȿ�
	if(loadOption == 1)
				leftFileName = filename;
			else
				rightFileName = filename;
	�߰�
	
2. controller�� loadeventhandler �Ķ���� �߰��Ѱ��������Ƿ� �׿� ����  �Ķ���� �Ѱ� �� �־���

3. save �ߵ��ư��� �ٲ�
	