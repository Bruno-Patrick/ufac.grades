// package com.notax.notax_project.infra.springboot.controller.useCases.User;

// import java.util.List;
// import java.util.stream.Collectors;

// import com.notax.notax_project.application.DTO.UserDTO;
// import com.notax.notax_project.infra.shared.validators.IValidator;
// import com.notax.notax_project.infra.springboot.controller.useCases.IBooleanUseCase;
// import com.notax.notax_project.infra.springboot.entities.UserModel;
// import com.notax.notax_project.infra.springboot.repository.UserRepository;

// public class GetUserBySearchTermUseCase implements IBooleanUseCase<String, Boolean, List<UserDTO>> {

//     private UserRepository userRepository;
//     private List<IValidator<String, Exception>> validators;

//     public GetUserBySearchTermUseCase(
//         UserRepository userRepository,
//         List<IValidator<String, Exception>> validators
//     ) {
//         this.userRepository = userRepository;
//         this.validators = validators;
//     }

//     @Override
//     public List<UserDTO> execute(String searchTerm, Boolean bool) throws Exception {

//         for (IValidator<String, Exception> validator : validators) {
//             validator.validate(searchTerm);
//         }

//         List<UserModel> data = this.userRepository.findBySearchTerm(searchTerm, bool);
//         return data.stream()
//             .map(
//                 model -> new UserDTO(model.toEntity())
//             ).collect(Collectors.toList()
//         );
//     }

// }
