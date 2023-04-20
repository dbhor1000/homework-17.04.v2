package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDao userDaoMock;

    private UserService out;

    @BeforeEach
    public void initOutAndDatabase() {
        userDaoMock = new UserDaoImpl();
        out = new UserService(userDaoMock);
    }

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(TestConstants.DEFAULT_NAME1),
                Arguments.of(TestConstants.DEFAULT_NAME2),
                Arguments.of(TestConstants.DEFAULT_NAME3),
                Arguments.of(TestConstants.DEFAULT_NAME4),
                Arguments.of(TestConstants.DEFAULT_NAME5)

        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void checkUserExistShouldReturnTrue(String name) {
        Assertions.assertTrue(out.checkUserExist(name));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void checkUserExistShouldReturnFalse(String name) {
        Assertions.assertFalse(out.checkUserExist(name));
    }
}
