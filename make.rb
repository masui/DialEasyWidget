#
# らくらくホンWidgetを生成する
# 2014/12/08 09:52:43 masui@pitecan.com
#
name = ARGV.shift
number = ARGV.shift
if !name || !number then
  STDERR.puts "% make.rb name number"
  exit
end

if !File.exist?("#{name}.png") then
  STDERR.puts "Please prepare '#{name}.png' file."
  exit
end

DIR = File.expand_path("~/DialEasyWidget")

system "cd #{DIR}; make clean"
system "/bin/rm -f #{DIR}/res/drawable-hdpi/*"
system "cp #{name}.png #{DIR}/res/drawable-hdpi"

files = [
         'AndroidManifest.xml',
         'build.xml',
         'res/layout/dialeasy.xml',
         'res/values/strings.xml',
         'res/xml/dialeasy_info.xml',
]

files.each { |filename|
  File.open("#{DIR}/#{filename}","w"){ |o|
    File.open("#{DIR}/template/#{filename}"){ |i|
      i.each { |line|
        line.gsub!('##name##',name)
        line.gsub!('##number##',number)
        o.print line
      }
    }
  }
}

src = "#{DIR}/template/src/com/pitecan/dialeasy/DialEasy.java"
dest = "#{DIR}/src/com/pitecan/dialeasy_#{name}/DialEasy_#{name}.java"

system "/bin/rm -r -f #{DIR}/src/com/pitecan"
system "mkdir #{DIR}/src/com/pitecan"
system "mkdir #{DIR}/src/com/pitecan/dialeasy_#{name}"

File.open(dest,"w"){ |o|
  File.open(src){ |i|
    i.each { |line|
      line.gsub!('##name##',name)
      line.gsub!('##number##',number)
      o.print line
    }
  }
}

system "pushd #{DIR}; make; popd"
system "/bin/cp #{DIR}/bin/Widget-debug.apk #{name}.apk"



