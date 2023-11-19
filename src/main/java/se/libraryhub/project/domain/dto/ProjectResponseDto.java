package se.libraryhub.project.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.libraryhub.project.domain.Project;
import se.libraryhub.user.domain.User;
import se.libraryhub.user.domain.dto.UserResponseDto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectResponseDto {

    private Long projectId;

    private UserResponseDto userResponseDto;

    private String projectname;

    private String projectLink;

    private Boolean isPublic;

    @Builder
    public ProjectResponseDto(Long projectId, UserResponseDto userResponseDto, String projectname, String projectLink, Boolean isPublic) {
        this.projectId = projectId;
        this.userResponseDto = userResponseDto;
        this.projectname = projectname;
        this.projectLink = projectLink;
        this.isPublic = isPublic;
    }

    public static ProjectResponseDto of(Project project, User user){
        return ProjectResponseDto.builder()
                .projectId(project.getProjectId())
                .userResponseDto(UserResponseDto.of(user))
                .projectname(project.getProjectname())
                .projectLink(project.getProjectLink())
                .isPublic(project.getIsPublic())
                .build();
    }
}
