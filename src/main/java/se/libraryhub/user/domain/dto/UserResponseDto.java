package se.libraryhub.user.domain.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import se.libraryhub.user.domain.Role;
import se.libraryhub.user.domain.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    private final String profileImageUrl;

    private final Role role;

    private final LocalDateTime createDate;

    private final LocalDateTime modifiedDate;

    @Builder
    public UserResponseDto(Long id, String username, String email, String profileImageUrl, Role role, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.role = role;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public static UserResponseDto of(User user){
        return UserResponseDto.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .profileImageUrl(user.getProfileImageUrl())
                .id(user.getId())
                .role(user.getRole())
                .createDate(user.getCreateDate())
                .modifiedDate(user.getModifiedDate())
                .build();
    }

}
