## repo-migration

Repository Migration Scripts and Configuration.

### What has moved where!?

The following steps took place during the repository migration in
Jan/Feb 2013.

* new github.pages site deployed at http://haskell-distributed.github.com
* all distributed-process wiki content moved to new github.pages site
* some wiki content merged into the documentation and/or tutorials sections
* all github issues migrated to https://cloud-haskell.atlassian.net (see jira sub-folder for details)
* all sub-projects in distributed-process moved into their own git repos bar one
* all the content under the distributed-process/distributed-process moved *up* one directory
* travis-ci builds set up for most (actively developed) projects

### Help - something has gone missing!

All git history for the sub-folders extracted from distributed-process should
have been preserved. None of the repositories git history was destructively overwritten,
so if something did go wrong it should be easy to fix.

If you require further information, please contact the Cloud Haskell maintainers
via the parallel-haskell google group (mailing list - parallel-haskell@googlegroups.com)
and we'll be happy to help.
