# split up the canonical distributed-process repo
# extracting history for each sub-repository

# repository extraction technique taken from
# http://stackoverflow.com/questions/359424/detach-subdirectory-into-separate-git-repository

BUILD=/tmp/repo-mig
BASE_REPO=$(BUILD)/distributed-process
BASE_GIT=git@github.com:haskell-distributed/distributed-process.git
# REPOS=$(shell ls | awk '/distributed-|network-|azure|rank1/ { print $$NF }')
REPOS=azure-service-api \
	  distributed-process-azure \
	  distributed-process-demos \
	  distributed-process-simplelocalnet \
	  distributed-static \
	  network-transport  \
	  network-transport-composed \
	  network-transport-inmemory \
	  network-transport-tcp \
	  network-transport-tests \
	  rank1dynamic

TARGETS=$(foreach r,$(REPOS),$(BUILD)/$(r))

all: $(TARGETS)

$(TARGETS):
	git clone $(BASE_GIT) $@
	git --git-dir=$@/.git --work-tree=$@ remote rm origin
	git --git-dir=$@/.git --work-tree=$@ branch -t $i origin/development
	cd $@ && basename `pwd` >> $@/dirname
	git --git-dir=$@/.git --work-tree=$@ tag -l | grep -v "`cat $@/dirname`-0" | xargs \
		git --git-dir=$@/.git --work-tree=$@ tag -d
	cd $@ && git filter-branch --tag-name-filter cat --prune-empty --subdirectory-filter "`cat $@/dirname`" -- --all
	git --git-dir=$@/.git --work-tree=$@ reset --hard
	git --git-dir=$@/.git --work-tree=$@ \
		for-each-ref --format="%(refname)" refs/original/ | xargs -n 1 \
			git --git-dir=$@/.git --work-tree=$@ update-ref -d
	git --git-dir=$@/.git --work-tree=$@ reflog expire --expire=now --all
	git --git-dir=$@/.git --work-tree=$@ gc --aggressive --prune=now
	cat REPOS | sed "s/`cat $@/dirname`//g" >> $@/REPOS
	cp Makefile.template $@/Makefile
	cat README.md | sed "s/@REPO@/`cat $@/dirname`/g" >> $@/README.md
	rm $@/dirname
