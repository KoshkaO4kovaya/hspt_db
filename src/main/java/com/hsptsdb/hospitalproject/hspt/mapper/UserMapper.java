package com.hsptsdb.hospitalproject.hspt.mapper;

import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.hsptsdb.hospitalproject.hspt.model.GenericModel;
import com.hsptsdb.hospitalproject.hspt.mapper.GenericMapper;


//@Component
//public class UserMapper
//        extends GenericMapper<User, UserDTO> {

//    private final BookRentInfoRepository bookRentInfoRepository;
//
//    protected UserMapper(ModelMapper modelMapper,
//                         BookRentInfoRepository bookRentInfoRepository) {
//        super(User.class, UserDTO.class, modelMapper);
//        this.bookRentInfoRepository = bookRentInfoRepository;
//    }

//    @Override
//    protected void setupMapper() {
//        modelMapper.createTypeMap(User.class, UserDTO.class)
//                .addMappings(m -> m.skip(UserDTO::setUserBooksRent)).setPostConverter(toDTOConverter());
//        modelMapper.createTypeMap(UserDTO.class, User.class)
//                .addMappings(m -> m.skip(User::setBookRentInfos)).setPostConverter(toEntityConverter());
//    }

//    @Override
//    protected void mapSpecificFields(UserDTO source, User destination) {
//        if (!Objects.isNull(source.getUserBooksRent())) {
//            destination.setBookRentInfos(bookRentInfoRepository.findAllById(source.getUserBooksRent()));
//        }
//        else {
//            destination.setBookRentInfos(Collections.emptyList());
//        }
//    }

//    @Override
//    protected void mapSpecificFields(User source, UserDTO destination) {
//        destination.setUserBooksRent(getIds(source));
//    }
//
//    @Override
//    protected List<Long> getIds(User entity) {
//        return Objects.isNull(entity) || Objects.isNull(entity.getBookRentInfos())
//                ? null
//                : entity.getBookRentInfos().stream()
//                .map(GenericModel::getId)
//                .collect(Collectors.toList());
//    }
//}
