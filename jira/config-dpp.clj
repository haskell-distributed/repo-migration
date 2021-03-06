; ghijira configuration for migrating distributed-process-platform to jira

{
 ; Github login:
 :auth "watson.timothy@gmail.com:<PASSWORD>"
 
 ; Project owner and name:
 :ghuser "haskell-distributed"
 :ghproject "distributed-process-platform"

 ; Maximum number of comments per issue
 :maxcmt 100
 
 ; JIRA project setting - will be used to convert #123 to ABC-123
 ; so that source control integration still works.
 :jira-project "DPP"

 ; Git base URL - used to translate GHI "referenced" events to
 ; comments with a URL pointing to the link.
 :git-base-url "https://github.com/haskell-distributed/distributed-process-platform/"
 
 ; Translate user names from 
 :user-map
 { "hyperthunk" "hyperthunk"
   "edsko" "edsko" }
}
