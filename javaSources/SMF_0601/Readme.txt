추가 수정사항

1. SimpleMergeController에 addActionLister수행

2. EventHandler와 모두 Controller에서 연결되는 과정에서
SimpleMergeFrame에 있던 public static int saveOption변수를
SimpleMergeController로 옮김. SaveEventHandler의
SimpleMergeFrame.saveOption
=>SimpleMergeController.saveOption 변경




2018-05-31 추가 수정사항

1.LoadEventHandler에 
	private int loadOption;
	public static String leftFileName = null;
	public static String rightFileName = null;
	추가
	
	생성자에 파라미터 한개 추가시킴
	
	actionperformed 함수안에
	if(loadOption == 1)
				leftFileName = filename;
			else
				rightFileName = filename;
	추가
	
2. controller에 loadeventhandler 파라미터 추가한개시켰으므로 그에 따른  파라미터 한개 더 넣어줌

3. save 잘돌아가게 바꿈
	