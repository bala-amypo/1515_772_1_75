import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // POST /auth/register
    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(
            @RequestBody RegisterRequest request) {

        UserEntity user = userService.register(request);
        return ResponseEntity.ok(user);
    }

    // POST /auth/login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {

        AuthResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}
