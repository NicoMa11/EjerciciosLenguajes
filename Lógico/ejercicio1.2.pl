aplanar([], []).
aplanar([X|Xs], Ys) :-
    aplanar(X, Y),
    aplanar(Xs, Ys1),
    append(Y, Ys1, Ys).
aplanar(X, [X]) :- not(is_list(X)).

%aplanar([1,2,[3,[4,5],[6,7]]],X).
