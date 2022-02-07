package spring.turbo.examples.visitor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring.turbo.bean.Scopes;
import spring.turbo.bean.valueobject.ValueObjectFilter;
import spring.turbo.examples.valueobject.User;

@Slf4j
@Component
@Scope(Scopes.PROTOTYPE)
final class UserFilter implements ValueObjectFilter<User> {

    public UserFilter() {
        log.info("创建了一个Filter");
    }

    @Override
    public boolean test(User data) {
        return true;
    }

}
