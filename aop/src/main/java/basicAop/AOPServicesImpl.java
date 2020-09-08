package basicAop;

public class AOPServicesImpl implements IAOPServices {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String withAopMethod() throws Exception {
        System.out.println("AOP函数运行方法:withAopMethod");
        if (description.trim().length() == 0) {
            throw new Exception("description为空");
        }
        return description;
    }

    public String withNoAopMethod() throws Exception {
        System.out.println("无AOP函数运行方法:withNoAopMethod");
        return description;
    }
}
