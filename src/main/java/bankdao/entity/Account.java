package bankdao.entity;


    public class Account {
        private double balance;
        private String account_id;
        private int branch_id;
        private String account_type;

        private int account_holder_id;

        public Account() {
        }

        public Account(String account_id, int branch_id, String account_type, double balance, int account_holder_id) {
            this.account_id = account_id;
            this.branch_id = branch_id;
            this.account_type = account_type;
            this.balance = balance;
            this.account_holder_id = account_holder_id;
        }

        public String getAccount_id() {
            return account_id;
        }

        public void setAccount_id(String account_id) {
            this.account_id = account_id;
        }

        public int getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(int branch_id) {
            this.branch_id = branch_id;
        }

        public String getAccount_type() {
            return account_type;
        }

        public void setAccount_type(String account_type) {
            this.account_type = account_type;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public int getAccount_holder_id() {
            return account_holder_id;
        }

        public void setAccount_holder_id(int account_holder_id) {
            this.account_holder_id = account_holder_id;
        }



        @Override
        public String toString() {
            return "Account{" +
                    "account_id=" + account_id +
                    ", branch_id=" + branch_id +
                    ", account_type='" + account_type + '\'' +
                    ", balance=" + balance +
                    ", account_holder_id=" + account_holder_id +
                    '}';
        }
    }

