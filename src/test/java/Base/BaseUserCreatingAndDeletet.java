package Base;

import Client.UserClientCreating;
import Client.UserClientDeleted;
import Client.UserClientLogin;
import DTO.UserDTO;
import DTO.UserResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

public class BaseUserCreatingAndDeletet {

    @Before
    public void creating() {

        String baseUrl = RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        UserClientCreating userClientCreating = new UserClientCreating();
        Response response = userClientCreating.Creating(user);

    }

    @After
    public void delited() {

        UserDTO user = new UserDTO("ivanov_101@gmail.com", "1234567", "ivanov");

        //Вход в систему
        UserClientLogin userClientLogin = new UserClientLogin();
        Response response = userClientLogin.Login(user);

        //Десериализация
        UserResponse userResponse = response.as(UserResponse.class);
        //удаление начала токена
        String accessToken = userResponse.getAccessToken().substring(7);

        //Удаление пользователя
        UserClientDeleted userClientDeleted = new UserClientDeleted();
        Response response_1 = userClientDeleted.Delete(accessToken);
    }
}
