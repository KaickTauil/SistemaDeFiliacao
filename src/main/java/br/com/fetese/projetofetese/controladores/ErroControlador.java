package br.com.fetese.projetofetese.controladores;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class ErroControlador implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public String getErrorPath() {
        return "/error";
    }

    public String handleError(HttpServletRequest request, Model model) {
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String, Object> errorAttributes = getErrorAttributes(webRequest);
        String errorDetail = (String) errorAttributes.get("error");
        model.addAttribute("errorDetail", errorDetail != null ? errorDetail : "Unknown error");
        return "error";
    }

    public ErroControlador(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    private Map<String, Object> getErrorAttributes(WebRequest webRequest) {
        ErrorAttributeOptions options = ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE);
        return errorAttributes.getErrorAttributes(webRequest, options);
    }



}
