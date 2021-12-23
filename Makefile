timestamp := $(shell /bin/date "+%F %T")

clean:
	@$(CURDIR)/gradlew clean

github: clean
	@git add .
	@git commit -m "$(timestamp)"
	@git push

.PHONY: clean github