window.onload = async() => {
    await MostrarTabla();
}

async function MostrarTabla(){
    const rs = await fetch('http://localhost:8080/bancos');
        const bancos = await rs.json();
        bancos.forEach(elemento => {
            document.getElementById('tablaBody').innerHTML += `
                <tr>
                    <td>${elemento.id}</td>
                    <td>${elemento.nombre}</td>
                    <td>${elemento.deuda}</td>
                    <td>${elemento.pagado == '1' ? 'si' : 'no'}</td>
                    <td><button onclick='Pagar(${elemento.id},  ${elemento.deuda})' value=${elemento.id}>Pagar</button></td>
                </tr>
            `
    })
}

function Pagar(id, deuda) {
    console.log(id)
    document.getElementById('pagar').style.display = 'block';
    document.getElementById('cantidad').innerHTML = deuda;
    document.getElementById('PagarBtn').innerHTML = `<button type='submit' onclick='PagarDeuda(${id})'>Pagar Deuda</button>`
}

async function PagarDeuda(id) {
    console.log(id)
    await fetch('http://localhost:8080/bancos/pagar/' + id,
            {
                method: 'GET',
            })

}

function tipoPago(e){
    console.log(e.value)
    switch (e.value){
        case 'cuota':
            document.getElementById('cuotas').style.display = 'block';
            document.getElementById('pagoCompleto').style.display = 'none';
            break;
        case 'completo':
            document.getElementById('pagoCompleto').style.display = 'block';
            document.getElementById('cuotas').style.display = 'none';
            break;

    }
    document.getElementById('PagarBtn').style.display = 'block';
}