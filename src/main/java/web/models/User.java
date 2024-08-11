package web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "name") // ,nullable = false
    //@NonNull //можно уточнить @NonNullApi (область действия = параметры + возвращаемые значения) и / или @NonNullFields
    private String userName;

    @Column(name = "age")
    private int userAge;

    @Column(name = "email")
    private String userEmail;

    public User() {
    }

    public User(String userName, int userAge, String userEmail) {
        this.userName = userName;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }

    public User(int userId, String userName, int userAge, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(getUserId());
        sb.append(", userName='").append(getUserName()).append('\'');
        sb.append(", userAge=").append(getUserAge());
        sb.append(", userEmail='").append(getUserEmail()).append('\'');
        sb.append('}');
        return sb.toString();
    }


}