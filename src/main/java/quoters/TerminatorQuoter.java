package quoters;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {
    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
    }
    public TerminatorQuoter(){
        System.out.println("Phase 1");
    }
    @InjectRandomInt(min=2, max=7)
    private int repeat;
    private String message;
    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("3 phase");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
