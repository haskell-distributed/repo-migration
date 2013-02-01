#!/usr/bin/env python

import sys
import os
import os.path

REPO_BASE="git@github.com:haskell-distributed/%s.git"

dir = sys.argv[1]
base = os.path.basename(dir)
readme = os.path.join(dir, "README.md")
with open(readme, 'a') as f:
    f.write(("### %s\n\n" % base))
    f.write("This repository is part of Cloud Haskell.\n\n"
            "See http://haskell-distributed.github.com for more documentation,\n"
            "user guides, license details and getting assistance.\n\n"
            "Please submit issues to our bug tracker: http://cloud-haskell.atlassian.net\n")
