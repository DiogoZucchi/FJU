package testePhaseListener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthorizationListener implements PhaseListener {
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
        // objeto de FacesContext recebe a contexto da requisição acessada nessa Phase.
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        // Esta linha acima pega a sessão atual do FacesContext, e se ela nao existir ele cria uma
        String usuarioOn = (String) session.getAttribute("usuarioOn");
        // Este atributo é setado na sessão sempre que o usuário fazer a autenticação
        String currentPage = fc.getViewRoot().getViewId();
        // Esta String recebe a View que está sendo chamada na requisição desta Phase
        // A partir daqui é muito básico e intuitivo.
        if (!currentPage.contains("Login") && usuarioOn == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/GED_PROJ_Web_RestauraDocs/redirect.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AuthorizationListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (currentPage.contains("Login") && usuarioOn != null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/GED_PROJ_Web_RestauraDocs/MainPage.faces");
            } catch (IOException ex) {
                Logger.getLogger(AuthorizationListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void beforePhase(PhaseEvent event) {
    }
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}