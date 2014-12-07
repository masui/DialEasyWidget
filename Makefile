all:
	ant debug
install:
	adb install -r bin/Widget-debug.apk
clean:
	/bin/rm -r -f bin gen
	/bin/rm -r -f *~
	/bin/rm -r -f */*~
	/bin/rm -r -f */*/*~
	/bin/rm -r -f */*/*/*~
	/bin/rm -r -f */*/*/*/*~
	/bin/rm -r -f */*/*/*/*/*~

# % dialeasy name phone#
# % dialeasy toshiyuki 08023881513 # toshiyuki.apk ができる

