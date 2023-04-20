package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserDaoTest {

    private UserDao out;

    @BeforeEach
    public void initOut() {
        out = new UserDaoImpl();
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
    public void getUserByNameReturnsObjectIfPresent (String name) {
        Assertions.assertNotNull(out.getUserByName(name));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void getUserByNameDoesNotReturnObjectIfAbsent (String name) {
        Assertions.assertNull(out.getUserByName(name));
    }

}