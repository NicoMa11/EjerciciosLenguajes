distanciaH(Cadena1, Cadena2, Distancia) :-
    atom_chars(Cadena1, Chars1),
    atom_chars(Cadena2, Chars2),
    length(Chars1, Len1),
    length(Chars2, Len2),
    min_length(Len1, Len2, MinLen),
    distanciaH_aux(Chars1, Chars2, MinLen, 0, Distancia).

distanciaH_aux(_, _, 0, Distancia, Distancia).

distanciaH_aux([Char1|Resto1], [Char2|Resto2], N, TempDistancia, Distancia) :-
    (Char1 \= Char2 -> TempDistancia1 is TempDistancia + 1 ; TempDistancia1 is TempDistancia),
    N1 is N - 1,
    distanciaH_aux(Resto1, Resto2, N1, TempDistancia1, Distancia).

min_length(Len1, Len2, MinLen) :-
    (Len1 < Len2 -> MinLen = Len1 ; MinLen = Len2).

%distanciaH("romano","camino",X).
