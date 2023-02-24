usage:
	@echo "========================================================================================="
	@echo "usage             : 显示本菜单"
	@echo "clean             : 清理项目"
	@echo "wrapper           : 初始化MavenWrapper"
	@echo "github            : 推送文件到github.com"
	@echo "version           : 更改版本号"
	@echo "========================================================================================="

wrapper:
	@mvn wrapper:wrapper -Dmaven=3.9.0

clean:
	@mvnw clean -q

version:
	@mvnw -f $(CURDIR)/pom.xml versions:set
	@mvnw -f $(CURDIR)/pom.xml -N versions:update-child-modules
	@mvnw -f $(CURDIR)/pom.xml versions:commit

github: clean
	@git status
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage wrapper clean version github
