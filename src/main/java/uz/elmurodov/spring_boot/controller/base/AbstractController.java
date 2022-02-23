package uz.elmurodov.spring_boot.controller.base;
import uz.elmurodov.spring_boot.services.base.BaseService;

public abstract class AbstractController<S extends BaseService> {
    protected final S service;

    public AbstractController(S service) {
        this.service = service;
    }
}
