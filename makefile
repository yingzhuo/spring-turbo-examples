usage:
	@echo "========================================================================================="
	@echo "usage             : 显示本菜单"
	@echo "clean             : 清理项目"
	@echo "compile           : 编译项目源码"
	@echo "github            : 推送文件到github.com"
	@echo "version           : 更改版本号"
	@echo "========================================================================================="

clean:
	@mvn clean

compile:
	@mvn clean compile

version:
	@mvn -f $(CURDIR)/pom.xml versions:set
	@mvn -f $(CURDIR)/pom.xml -N versions:update-child-modules
	@mvn -f $(CURDIR)/pom.xml versions:commit

github: clean
	@git status
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage clean compile version github
