package searchengine.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import searchengine.dto.statistics.IndexingErrorResult;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<IndexingErrorResult> handle(Exception ex) {
        IndexingErrorResult indexingErrorResult = new IndexingErrorResult();
        indexingErrorResult.setError(ex.getMessage());
        return ResponseEntity.internalServerError()
                .body(indexingErrorResult);
    }
}