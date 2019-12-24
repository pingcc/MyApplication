package com.example.java;

/**
 * Created  on 2018/12/6.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class SaleTicketSystem {
    public  int tickets=1000;
    /**模仿一个卖票系统 ，暂时不考虑服务器，硬件配置，4太机器卖票*/
    public static void main(String[] args){
        for(int i=1;i<5;i++){
            SaleTicketSystem saleTicketSystem=new SaleTicketSystem();
            TicketRunnable ticketRunnable=new TicketRunnable(saleTicketSystem);
            new Thread(ticketRunnable).start();
        }
    }
    public synchronized void ticket(){
        while (tickets>0){
            tickets--;
            System.out.println("机器"+Thread.currentThread().getName()+"卖票: ----"+tickets);
        }

    }


    public static class TicketRunnable implements Runnable{
       private SaleTicketSystem saleTicketSystem;

        public TicketRunnable(SaleTicketSystem saleTicketSystem) {
            this.saleTicketSystem = saleTicketSystem;
        }

        @Override
        public void run() {
            saleTicketSystem.ticket();
        }
    }
 }
