class Runner{

    public static void main(String args[]) throws InterruptedException {
    
    Thread login = new Thread(new Runnable() {
        @Override
        public void run() {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                new LoginForm().setVisible(true);
                }
            });
        }
    });
    
    Thread main = new Thread(new Runnable() {
        @Override
        public void run() {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MainScreenForm().setVisible(true);
                }
            });
        }
    });
    
    login.start();
    
    while(LoginForm.displayed == true){
        //do nothing when login is still being displayed
        login.sleep(1);
    }
    
    main.start();
    
    }
}