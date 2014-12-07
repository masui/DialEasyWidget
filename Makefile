all:
	ant debug
install:
	adb install -r bin/Widget-debug.apk
clean:
	/bin/rm -r -f bin gen
	/bin/rm -r -f *~
	/bin/rm -r -f hankyu.apk
	/bin/rm -r -f */*~
	/bin/rm -r -f */*/*~
	/bin/rm -r -f */*/*/*~
	/bin/rm -r -f */*/*/*/*~
	/bin/rm -r -f */*/*/*/*/*~

test:
	ruby make.rb hankyu 079866271


