package com.baeldung.mapstruct.custom

import com.baeldung.mapstruct.simple.*
import org.mapstruct.factory.Mappers

open class UserMapperDecorator: DecoratedMapper() {

    var userMapper: UserMapper = Mappers.getMapper(UserMapper::class.java)

    override fun toDto(user: User): UserDto {
        val userDto = userMapper.toDto(user)
        userDto.name = "Mr. " + userDto.name
        return userDto
    }

    override fun toBean(userDto: UserDto): User {
        return userMapper.toBean(userDto)
    }

    override fun toAddressDto(address: Address): AddressDto {
        return userMapper.toAddressDto(address)
    }

    override fun toAddress(addressDto: AddressDto): Address {
        return userMapper.toAddress(addressDto)
    }
}