package pl.edu.pw.mini.annotations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnotationCreationDto {
    private Long pageId;
    private AnnotationDto annotation;
    private List<Long> annotationsUsed;
    private List<String> tags;
    private List<Long> references;
    private Map<String, Object> additionalInfo;
}
