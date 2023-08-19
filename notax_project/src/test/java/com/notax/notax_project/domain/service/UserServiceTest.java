package com.notax.notax_project.domain.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // @InjectMocks
    // UserService service;

    // @Mock
    // UserRepository repo;
    // @Mock
    // ModelMapper modelMapper;

    // UserModel user;
    // UserModel user2;
    // UserDTO userDTO;

    // @BeforeEach
    // public void setup() {
    //     modelMapper = new ModelMapper();
    //     user = new UserModel();
    //     user.setBirthDate(java.sql.Date.valueOf(LocalDate.of(2002, Month.MAY, 17)));
    //     user.setEmail("gradestest@teste.com");
    //     user.setFirstName("User");
    //     user.setLastName("of Tests");
    //     user.setIsActive(true);
    //     user.setPassword("12345", true);
    //     user.setPhone("+5568992493873");

    //     user2 = new UserModel();
    //     user2.setBirthDate(java.sql.Date.valueOf(LocalDate.of(2002, Month.MAY, 17)));
    //     user2.setEmail("gradestest2@teste.com");
    //     user2.setFirstName("User");
    //     user2.setLastName("of Tests2");
    //     user2.setIsActive(true);
    //     user2.setPassword("12345", true);
    //     user2.setPhone("+5568992493873");

    //     userDTO = new UserDTO();
    //     userDTO.setBirthDate(user.getBirthDate());
    //     userDTO.setCreateTime(user.getCreateTime());
    //     userDTO.setEmail(user.getEmail());
    //     userDTO.setFirstName(user.getFirstName());
    //     userDTO.setLastName(user.getLastName());
    //     userDTO.setId(user.getId());
    //     userDTO.setIsActive(user.getIsActive());
    //     userDTO.setPassword(user.getPassword());
    //     userDTO.setPhone(user.getPhone());
    // }

    // @Test
    // public void shouldBeAbleToConverterUserModelInUserDTO() {
    //     when(repo.findByEmailAndIsActiveTrue(user.getEmail())).thenReturn(user);
    //     try {
    //     UserService service = new UserService(repo, modelMapper);
    //     UserDTO userRetrieved = service.getByEmail(userDTO.getEmail());

    //     assertEquals(userDTO.getId(), userRetrieved.getId());
    //     assertEquals(userDTO.getEmail(), userRetrieved.getEmail());
    //     assertEquals(userDTO.getFirstName(), userRetrieved.getFirstName());
    //     assertEquals(userDTO.getLastName(), userRetrieved.getLastName());
    //     assertEquals(userDTO.getBirthDate(), userRetrieved.getBirthDate());
    //     assertEquals(userDTO.getPhone(), userRetrieved.getPhone());
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    // @Test
    // public void shouldBeAbleToConvertAListOfUserModelInUserDTO() {
    //     when(repo.findAllByIsActiveTrue()).thenReturn(Arrays.asList(user, user2));
    //     try {
    //         UserService service = new UserService(repo, modelMapper);
    //         List<UserDTO> retrievedList = service.getAll();

    //         assertTrue(retrievedList.size() == 2);
    //         retrievedList.forEach(dto -> {
    //             assertTrue(
    //                 dto.getEmail().equals(user.getEmail()) ?
    //                 true :
    //                 dto.getEmail().equals(user2.getEmail())
    //             );
    //         });
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}
