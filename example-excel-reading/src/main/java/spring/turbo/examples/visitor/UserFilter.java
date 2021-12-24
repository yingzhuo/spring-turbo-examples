package spring.turbo.examples.visitor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring.turbo.bean.Scopes;
import spring.turbo.examples.valueobject.User;
import spring.turbo.module.excel.filter.ValueObjectFilter;

@Slf4j
@Component
@Scope(Scopes.PROTOTYPE)
final class UserFilter implements ValueObjectFilter<User> {

    public UserFilter() {
        log.info("创建了一个Filter");
    }

    @Override
    public boolean filter(User data) {
        log.debug("user filter: always true");
        return true;
    }

}
