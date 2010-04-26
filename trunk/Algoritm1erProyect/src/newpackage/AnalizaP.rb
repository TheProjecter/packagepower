load "pilas.rb"

puts 'Introduce una cadena a evauluar: '
cadena = gets.chomp

valida = false
parentesis = Pila.new
cadena.each_char do |x|
	if x == "("
		parentesis.push(x)
	elsif x == ")"
		if parentesis.getTope == "("
			parentesis.pop
		elsif parentesis.getIndice < 0
			valida = true
			break
		end
	end
end

if valida || parentesis.getTope != nil
	puts 'error en sintaxis'
else
	puts 'sintaxis correcta'
end

parentesis = nil
