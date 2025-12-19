public interface UserService {

    UserEntity register(RegisterRequest request);

    AuthResponse login(AuthRequest request);

    UserEntity getByEmail(String email);
}
