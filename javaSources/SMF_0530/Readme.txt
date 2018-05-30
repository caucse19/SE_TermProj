추가 수정사항

1. SimpleMergeController에 addActionLister수행

2. EventHandler와 모두 Controller에서 연결되는 과정에서
SimpleMergeFrame에 있던 public static int saveOption변수를
SimpleMergeController로 옮김. SaveEventHandler의
SimpleMergeFrame.saveOption
=>SimpleMergeController.saveOption 변경

