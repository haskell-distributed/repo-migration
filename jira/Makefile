# pulls github-issues => jira csv export tool from github
# uses config-*.clj config files to control mapping/auth
# produces csv files that can be imported into JIRA

LEIN ?= $(shell which lein)
JAVA ?= $(shell which java)
BUILD ?= .build
GHIJ ?= $(BUILD)/ghijira
PROJ = dpp dp-full

all: dpp dp-full

clean:
	rm -rf .build

help:
	$(info don't forget to update the username/password in the config files!)
	$(info Requires Java: current install - ${JAVA})
	$(info Requires Leiningen: current install - ${LEIN})

$(PROJ): $(GHIJ)
	cp config-$@.clj $(GHIJ)
	cd $(GHIJ) && lein run $@

$(GHIJ):
	git clone git@github.com:kylecordes/ghijira.git $(GHIJ)
	git --git-dir=$(GHIJ)/.git --work-tree=$(GHIJ) checkout 5e804b8
	cd $@ && $(LEIN) deps
