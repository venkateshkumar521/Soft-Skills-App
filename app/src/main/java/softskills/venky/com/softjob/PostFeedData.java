package softskills.venky.com.softjob;

public class PostFeedData {
    String postId;
    String jobTitle;
    String jobLocation;
    String companyName;

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setJobDescription(String description) {
        jobDescription = description;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    String jobDescription;
    String contact;
    String emailID;
    PostFeedData(){

    }

    public PostFeedData(String postId, String jobTitle, String jobLocation,
                        String companyName, String jobDescription,String contact, String emailID) {
        this.postId = postId;
        this.jobTitle = jobTitle;
        this.jobLocation = jobLocation;
        this.companyName = companyName;
        this.jobDescription = jobDescription;
        this.contact = contact;
        this.emailID = emailID;
    }

    public String getPostId() {
        return postId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobDescription() {
        return jobDescription;
    }
    public String getContact() {
        return contact;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getEmailID() {
        return emailID;
    }
}